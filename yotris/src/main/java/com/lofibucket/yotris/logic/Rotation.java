/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lofibucket.yotris.logic;

/**
 * A rotation enum used by the Piece class to represent current orientation.
 */
public enum Rotation {
	/**
	 * The default orientation, no changes
	 */
	UP,
	/**
	 * rotated 90 degrees clockwise
	 */
	RIGHT,
	/**
	 * rotated 180 degrees clockwise
	 */
	DOWN,
	/**
	 * rotated 270 degrees clockwise
	 */
	LEFT
}
