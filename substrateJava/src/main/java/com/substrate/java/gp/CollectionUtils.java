package com.substrate.java.gp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by apple on 16/12/14.
 */
public class CollectionUtils {

    private static final String a = new String(new byte[]{(byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 48, (byte) 32, (byte) 40, (byte) 41, (byte) 58, (byte) 91, (byte) 93, (byte) 59, (byte) 47, (byte) 46, (byte) 45});
    private char[] b;

    public void run(String str) {
        int i;
        Random random = new Random((long) str.hashCode());
        this.b = (a + str).toCharArray();
        List arrayList = new ArrayList();
        for (char valueOf : this.b) {
            arrayList.add(Character.valueOf(valueOf));
        }
        Collections.shuffle(arrayList, random);
        for (i = 0; i < arrayList.size(); i++) {
            this.b[i] = ((Character) arrayList.get(i)).charValue();
        }
    }

    public final String a(int[] iArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : iArr) {
            if (i >= 0 && i < this.b.length) {
                stringBuilder.append(this.b[i]);
            }
        }
        return stringBuilder.toString();
    }
}
