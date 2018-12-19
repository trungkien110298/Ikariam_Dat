/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ui.HouseInfoUI;
import ui.IsLandUI;
import ui.MenuSetting;

public class IkariamTest {
	public static IsLandUI isLandUI;

	public static void Reset() {
		isLandUI.dispose();
		isLandUI = new IsLandUI("Ikariam");
		isLandUI.showWindow();
	}

	public static void Save() {
		try {
			FileOutputStream f = new FileOutputStream(new File("mySave.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(isLandUI);

			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
	}

	public static void Reload() {
		isLandUI.dispose();
		//IsLandUI tempIsLandUI = new IsLandUI("Ikarinam");
		try {
			FileInputStream fi = new FileInputStream(new File("mySave.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			isLandUI = (IsLandUI) oi.readObject();
			oi.close();
			fi.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//isLandUI = new IsLandUI("Ikariam");
		//isLandUI = tempIsLandUI;
		//isLandUI.house = tempIsLandUI.house;
		
		//isLandUI.houseInfoUI.addControls();
		//isLandUI.houseInfoUI.addEvents();
		isLandUI.houseInfoUI = new HouseInfoUI();
        isLandUI.menuSetting = new MenuSetting();
		isLandUI.addControls();
        isLandUI.addEvents();
		isLandUI.showWindow();
	}

	public static void main(String[] args) {
		isLandUI = new IsLandUI("Ikariam");
		isLandUI.showWindow();
	}
}
