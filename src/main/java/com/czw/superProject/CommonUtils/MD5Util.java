package com.czw.superProject.CommonUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.czw.superProject.Constants.ProConstants;

public class MD5Util {
	/**
	 *MD5加密 生成32位md5码
	 *@param  待加密字符串
	 *@return  返回32位md5码
	 */
	public static String md5Encode(String inputStr){
		MessageDigest md5;
		StringBuffer sb = new StringBuffer();
		try {
			md5 = MessageDigest.getInstance(ProConstants.MD5);
			byte[] byteArray = inputStr.getBytes(ProConstants.UTF8);
			byte[] md5Bytes = md5.digest(byteArray);
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int)md5Bytes[i]) & 0xff;
				if (val < 16) {
					sb.append(ProConstants.ZERO);
				}
				sb.append(Integer.toHexString(val));
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		return sb.toString();
	}
}
