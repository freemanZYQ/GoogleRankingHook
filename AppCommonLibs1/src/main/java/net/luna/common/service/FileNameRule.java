package net.luna.common.service;

import net.luna.common.service.impl.ImageSDCardCache;

import java.io.Serializable;

/**
 * File name rule, used when saving images in {@link ImageSDCardCache}
 * 
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2012-7-6
 */
public interface FileNameRule extends Serializable {

    /**
     * get file name, include suffix, it's optional to include folder.
     * 
     * @param imageUrl the url of image
     * @return
     */
    public String getFileName(String imageUrl);
}
