package com.tools.hackandroid.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ShellUtils {

	public static final String COMMAND_SU = "su";

	public static final String COMMAND_SH = "sh";

	public static final String COMMAND_EXIT = "exit\n";

	public static final String COMMAND_LINE_END = "\n";

	private ShellUtils() {
		throw new AssertionError();
	}

	public static CommandResult execCommand(String command, boolean isRoot) {
		return execCommand(new String[] { command }, isRoot, true);
	}

	public static CommandResult execCommand(List<String> commands, boolean isRoot) {
		return execCommand(commands == null ? null : commands.toArray(new String[] {}), isRoot, true);
	}

	public static CommandResult execCommand(String[] commands, boolean isRoot) {
		return execCommand(commands, isRoot, true);
	}
	
	public static CommandResult execCommand(String[] commands, boolean isRoot, boolean isNeedResultMsg) {
		int result = -1;
		if (commands == null || commands.length == 0) {
			return new CommandResult(result, null, null);
		}

		Process process = null;
		BufferedReader successResult = null;
		BufferedReader errorResult = null;
		StringBuilder successMsg = null;
		StringBuilder errorMsg = null;

		DataOutputStream os = null;
		try {
			//ProcessBuilder pb = new ProcessBuilder().redirectErrorStream(true).command("su");
			//process = pb.start();
			process = Runtime.getRuntime().exec(isRoot ? COMMAND_SU : COMMAND_SH);
			os = new DataOutputStream(process.getOutputStream());
			for (String command : commands) {
				if (command == null) {
					continue;
				}

				DLog.i("执行命令 # %s", command);
				// donnot use os.writeBytes(commmand), avoid chinese charset
				// error
				os.write(command.getBytes());
				os.writeBytes(COMMAND_LINE_END);
				os.flush();
			}
			os.writeBytes(COMMAND_EXIT);
			os.flush();

			result = process.waitFor();
			// get command result
			if (isNeedResultMsg) {
				successMsg = new StringBuilder();
				errorMsg = new StringBuilder();
				successResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
				errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String s;
				while ((s = successResult.readLine()) != null) {
					successMsg.append(s);
				}
				while ((s = errorResult.readLine()) != null) {
					errorMsg.append(s);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				if (successResult != null) {
					successResult.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				if (errorResult != null) {
					errorResult.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (process != null) {
				process.destroy();
			}
		}

		CommandResult commandResult = new CommandResult(result, successMsg != null ? successMsg.toString() : null,
				errorMsg != null ? errorMsg.toString() : null);
		//		DLog.w("结果: %s\n成功信息: %s\n失败信息: %s", result, successMsg.toString(), errorMsg.toString());
		if (result != 0) {
			DLog.w(commandResult.toString());
		}

		return commandResult;
	}
	
	public static class CommandResult {

		public int result;

		public String successMsg;

		public String errorMsg;

		public CommandResult(int result, String successMsg, String errorMsg) {
			this.result = result;
			this.successMsg = successMsg;
			this.errorMsg = errorMsg;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("CommandResult {\n");
			sb.append("  result=").append(result).append("\n");
			sb.append("  successMsg=\"").append(successMsg).append('\"').append("\n");
			sb.append("  errorMsg=\"").append(errorMsg).append('\"').append("\n");
			sb.append('}');
			return sb.toString();
		}
	}
}