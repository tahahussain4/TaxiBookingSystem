package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.RoleManagementController;
import com.fdmgroup.util.ScannerSupport;

public class RoleManagementView {
	Scanner scanner = new Scanner(System.in);
	RoleManagementController roleManagementController = new RoleManagementController();
	
	public void displayOptions(){
		System.out.println("Please select an option 1) Add Role  2)Delete role");
		String option = scanner.nextLine();
		
		switch(option){
			case "1":
				displayAddRole();
				break;
			case "2":
				displayDeleteRole();
				break;
			case "3":
				displayAllRoles();
				break;
			default:
				System.out.println("Please choose a correct option");
				displayOptions();
		}
	}
	
	private void displayAllRoles() {
		System.out.println("Here are all the roles : ");
//		roleManagementController.displayAllRoles();
	}

	private void displayDeleteRole() {
		System.out.println("Please enter the role id of the role you want to delete");
		int roleId = ScannerSupport.getInt();
		roleManagementController.deleteRole(roleId);	
	}

	public void displayAddRole(){
		System.out.println("What is the name of the role");
		String role = scanner.nextLine();
		roleManagementController.addRole(role);
	}
	
}
