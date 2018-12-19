/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import ui.IsLandUI;

public class IkariamTest {
	public static IsLandUI isLandUI;
    public static void reset(){
    	isLandUI.dispose();
    	isLandUI = new IsLandUI("Ikariam");
        isLandUI.showWindow();
    }
	public static void main(String[] args) {
          isLandUI = new IsLandUI("Ikariam");
          isLandUI.showWindow();
    }
}
