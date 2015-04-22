/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.co.gregs.powershopriddle;

import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author gregorygraham
 */
public class RiddleSolver {

	public static void main(String[] args) {
		final String riddle = "zjY29k4EpuaGzq6Gzg";
		byte[] decodeBase64 = Base64.decodeBase64(riddle);
		
		byte[] reverseBytes = new byte[decodeBase64.length];
		byte[] correctBytes = new byte[decodeBase64.length];
		int index = 1;
		
		for (byte byt: decodeBase64) {
			reverseBytes[index-1] = reverseBitOrder(byt);
			correctBytes[correctBytes.length-index] = reverseBitOrder(byt);
			index++;
		}
		
		System.out.println("DECODED: " + (new String(correctBytes)));
		System.out.println("DECODED: " + (new StringBuilder(new String(reverseBytes)).reverse()));

	}

	public static byte reverseBitOrder(byte b) {
		int converted = 0x00;
		converted ^= (b & 0b1000_0000) >> 7;
		converted ^= (b & 0b0100_0000) >> 5;
		converted ^= (b & 0b0010_0000) >> 3;
		converted ^= (b & 0b0001_0000) >> 1;
		converted ^= (b & 0b0000_1000) << 1;
		converted ^= (b & 0b0000_0100) << 3;
		converted ^= (b & 0b0000_0010) << 5;
		converted ^= (b & 0b0000_0001) << 7;

		return (byte) (converted & 0xFF);
	}

}
