import java.util.*;

import com.tcs.EmployeeDepOrg.service.EmployeeServiceImpl;
import com.tcs.EmployeeDepOrg.service.EmployeeService;
import com.tcs.EmployeeDepOrg.service.DepartmentServiceImpl;
import com.tcs.EmployeeDepOrg.service.DepartmentService;
import com.tcs.EmployeeDepOrg.service.OrganizationServiceImpl;
import com.tcs.EmployeeDepOrg.service.OrganizationService;
import com.tcs.EmployeeDepOrg.model.Employee;
import com.tcs.EmployeeDepOrg.model.Department;
import com.tcs.EmployeeDepOrg.model.Organization;

public class Main {

	public static void main(String[] args) 
	{
		boolean isRunning = true;
		Scanner in= new Scanner(System.in);
		
		List<Employee> empAll = null;
		List<Department> depAll = null;
		List<Organization> orgAll = null;
		
		Optional<Employee> empOp = null;
		Optional<Department> depOp = null;
		Optional<Organization> orgOp = null;
		
		Employee employee = new Employee();
		Department department = new Department();
		Organization organization = new Organization();
		
		Optional<List<Employee>> empListOp = null;
		Optional<List<Department>> depListOp = null;
		Optional<List<Organization>> orgListOp = null;
		
		EmployeeService empService = EmployeeServiceImpl.getInstance();
		DepartmentService depService = DepartmentServiceImpl.getInstance();
		OrganizationService orgService = OrganizationServiceImpl.getInstance();
		
		int select = 0;
		boolean isConfirmed = false;
		
		while(isRunning)
		{	
			System.out.println("Employee Services");
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. Search Employee");
			System.out.println("5. See all Employees");
			System.out.println("6. Find Employees by Organization\n");
			
			System.out.println("Department Services");
			System.out.println("7. Add Department");
			System.out.println("8. Update Department");
			System.out.println("9. Delete Department");
			System.out.println("10. Search Department");
			System.out.println("11. See all Departments");
			System.out.println("12. Find Department by Organization");
			System.out.println("13. See all Employees in a Department\n");
			
			System.out.println("Organization Services");
			System.out.println("14. Add Organization");
			System.out.println("15. Update Organization");
			System.out.println("16. Delete Organization");
			System.out.println("17. Search Organization");
			System.out.println("18. See all Employees in an Organization");
			System.out.println("19. See all Departments in an Organization");
			System.out.println("20. See all Organizations\n");
			
			System.out.println("21. Exit Program\n");
			
			System.out.print("Select an option from above and input a number: ");
			select = in.nextInt();
			
			switch(select) 
			{
				case 1:
						employee = new Employee();
						System.out.println("Please enter new employee information");
						System.out.print("ID: ");
						employee.setId(in.nextLong());
						System.out.print("Organization ID: ");
						employee.setOrganizationId(in.nextLong());
						System.out.print("Department ID: ");
						employee.setDepartmentId(in.nextLong());
						System.out.print("Name: ");
						employee.setName(in.nextLine());
						System.out.print("Age: ");
						employee.setAge(in.nextInt());
						System.out.print("Position: ");
						employee.setPosition(in.nextLine());
						empService.addEmployee(employee);
						System.out.println("Employee added.");
						returnToMenu();
						break;
						
				case 2:
						employee = new Employee();
						System.out.println("Please enter employee information to update");
						System.out.print("ID: ");
						employee.setId(in.nextLong());
						System.out.print("Organization ID: ");
						employee.setOrganizationId(in.nextLong());
						System.out.print("Department ID: ");
						employee.setDepartmentId(in.nextLong());
						System.out.print("Name: ");
						employee.setName(in.nextLine());
						System.out.print("Age: ");
						employee.setAge(in.nextInt());
						System.out.print("Position: ");
						employee.setPosition(in.nextLine());
						empService.updateEmployee(employee, employee.getId());
						System.out.println("Employee updated.");
						returnToMenu();
						break;
						
				case 3:
						employee = new Employee();
						System.out.println("Please enter employee ID to delete");
						System.out.print("ID: ");
						employee.setId(in.nextLong());
						isConfirmed = false;
						while (isConfirmed == false)
								{
									System.out.println("Are you sure you wish to delete this employee?");
									System.out.println("Input \'y\' to confirm, input \'n\' to return to menu");
									String answer = in.nextLine();
									if (answer.equals("y"))
									{
										isConfirmed = true;
										empService.deleteEmployee(employee, employee.getId());
										System.out.println("Employee deleted.");
										break;
									}
									else if (answer.equals("n"))
									{		
										isConfirmed = true;
										System.out.println("Employee not deleted.");
										break;
									}
									else
									{
										System.out.println("Please only enter \'y\' or \'n\'. Press Enter key to continue");
										try
										{
											System.in.read();
										}  
										catch(Exception e)
										{} 		
									}
									
								}
						returnToMenu();
						break;
						
				case 4:	
						employee = new Employee();
						System.out.println("Please enter employee ID to search");
						System.out.print("ID: ");
						employee.setId(in.nextLong());
						if (empService.findById(employee.getId()) != null)
						{
							empOp = empService.findById(employee.getId());
							employee = empOp.get();
							System.out.println("Employee found!");
							System.out.println(employee.toString());
						}
						else
						{
							System.out.println("Employee not found!");
						}
						returnToMenu(); 	
						break;
						
				case 5:
						if (empService.getEmployees() != null)
						{
							System.out.println("Showing all employees");
							empListOp = empService.getEmployees();
							empAll = empListOp.get();
							for(int i = 0; i < empAll.size();i++)
								System.out.println(empAll.get(i).toString());
						}
						else
						{
							System.out.println("No employees found!");
						}
						returnToMenu();
						break;
						
				case 6:
						employee = new Employee();
						System.out.println("Please enter organization ID");
						System.out.print("ID: ");
						employee.setOrganizationId(in.nextLong());
						if (empService.findByOrganizationId(employee.getOrganizationId()) != null)
						{
							System.out.println("Employees in organization found!");
							empListOp = empService.findByOrganizationId(employee.getOrganizationId());
							empAll = empListOp.get();
							for(int i = 0; i < empAll.size();i++)
								System.out.println(empAll.get(i).toString());
						}
						else
						{
							System.out.println("Employees in organization not found!");
						}
						returnToMenu();
						break;

				case 7:
						department = new Department();
						System.out.println("Please enter new department information");
						System.out.print("ID: ");
						department.setId(in.nextLong());
						System.out.print("Organization ID: ");
						department.setOrganizationId(in.nextLong());
						System.out.print("Name: ");
						department.setName(in.nextLine());
						depService.addDepartment(department);
						System.out.println("Department added.");
						returnToMenu();
						break;
					
				case 8:
						department = new Department();
						System.out.println("Please enter department information to update");
						System.out.print("ID: ");
						department.setId(in.nextLong());
						System.out.print("Organization ID: ");
						department.setOrganizationId(in.nextLong());
						System.out.print("Name: ");
						department.setName(in.nextLine());
						depService.updateDepartment(department, department.getId());
						System.out.println("Department updated.");
						returnToMenu();
						break;

				case 9:
						department = new Department();
						System.out.println("Please enter department ID to delete");
						System.out.print("ID: ");
						department.setId(in.nextLong());
						isConfirmed = false;
						while (isConfirmed == false)
						{
								System.out.println("Are you sure you wish to delete this department?");
								System.out.println("Input \'y\' to confirm, input \'n\' to return to menu");
								String answer = in.nextLine();
								if (answer.equals("y"))
								{
									isConfirmed = true;
									depService.deleteDepartment(department, department.getId());
									System.out.println("Department deleted.");
									break;
								}
								else if (answer.equals("n"))
								{		
									isConfirmed = true;
									System.out.println("Department not deleted.");
									break;
								}
								else
								{
									System.out.println("Please only enter \'y\' or \'n\'. Press Enter key to continue");
									try
									{
										System.in.read();
									}  
									catch(Exception e)
									{} 		
								}
								
							}
						returnToMenu();
						break;

				case 10:
						department = new Department();
						System.out.println("Please enter Department ID to search");
						System.out.print("ID: ");
						department.setId(in.nextLong());
						if (depService.findById(department.getId()) != null)
						{
							System.out.println("Department found!");
							depOp = depService.findById(department.getId());
							department = depOp.get();							
							System.out.println(department.toString());
						}
						else
						{
							System.out.println("Department not found!");
						}
						returnToMenu();
						break;

				case 11:
						if (depService.getDepartments() != null)
						{
							System.out.println("Departments found!");
							depListOp = depService.getDepartments();
							depAll = depListOp.get();
							for(int i = 0; i < depAll.size();i++)
								System.out.println(depAll.get(i).toString());
						}
						else
						{
							System.out.println("No employees found!");
						}
						returnToMenu();
						break;

				case 12:
						department = new Department();
						System.out.println("Please enter Organization ID to search");
						System.out.print("ID: ");
						department.setOrganizationId(in.nextLong());
						if (depService.findByOrganizationId(department.getOrganizationId()) != null)
						{
							System.out.println("Departments in organization found!");
							depListOp = depService.findByOrganizationId(department.getOrganizationId());
							depAll = depListOp.get();
							for(int i = 0; i < depAll.size();i++)
								System.out.println(depAll.get(i).toString());
						}
						else
						{
							System.out.println("Departments in organization not found!");
						}
						returnToMenu();
						break;

				case 13:
						department = new Department();
						System.out.println("Please enter Department ID to search");
						System.out.print("ID: ");
						department.setId(in.nextLong());
						if (depService.getEmployees(department.getId()) != null)
						{
							System.out.println("Showing all employees");
							empListOp = depService.getEmployees(department.getId());
							empAll = empListOp.get();
							for(int i = 0; i < empAll.size();i++)
								System.out.println(empAll.get(i).toString());
						}
						else
						{
							System.out.println("No employees found!");
						}
						returnToMenu();
						break;

				case 14:
						organization = new Organization();
						System.out.println("Please enter new organization information");
						System.out.print("ID: ");
						organization.setId(in.nextLong());
						System.out.print("Name: ");
						organization.setName(in.nextLine());
						System.out.print("Address: ");
						organization.setAddress(in.nextLine());
						orgService.addOrganization(organization);
						System.out.println("Organization added.");
						returnToMenu();
						break;

				case 15:
						organization = new Organization();
						System.out.println("Please enter organization information to update");
						System.out.print("ID: ");
						organization.setId(in.nextLong());
						System.out.print("Name: ");
						organization.setName(in.nextLine());
						System.out.print("Address: ");
						organization.setAddress(in.nextLine());
						orgService.updateOrganization(organization, organization.getId());
						System.out.println("Organization updated.");
						returnToMenu();
						break;

				case 16:
						organization = new Organization();
						System.out.println("Please enter organization ID to delete");
						System.out.print("ID: ");
						organization.setId(in.nextLong());
						isConfirmed = false;
						while (isConfirmed == false)
						{
							System.out.println("Are you sure you wish to delete this organization?");
							System.out.println("Input \'y\' to confirm, input \'n\' to return to menu");
							String answer = in.nextLine();
							if (answer.equals("y"))
							{
								isConfirmed = true;
								orgService.deleteOrganization(organization, organization.getId());
								System.out.println("Organization deleted.");
								break;
							}
							else if (answer.equals("n"))
							{		
								isConfirmed = true;
								System.out.println("Organization not deleted.");
								break;
							}
							else
							{
								System.out.println("Please only enter \'y\' or \'n\'. Press Enter key to continue");
								try
								{
									System.in.read();
								}  
								catch(Exception e)
								{} 		
							}
							
						}
						returnToMenu();
						break;

				case 17:
						organization = new Organization();
						System.out.println("Please enter Organization ID to search");
						System.out.print("ID: ");
						organization.setId(in.nextLong());
						if (orgService.findById(organization.getId()) != null)
						{
							orgOp = orgService.findById(organization.getId());
							organization = orgOp.get();
							System.out.println("Organization found!");
							System.out.println(organization.toString());
						}
						else
						{
							System.out.println("Employee not found!");
						}
						returnToMenu();
						break;
						
				case 18:
						organization = new Organization();
						System.out.println("Please enter Organization ID to search");
						System.out.print("ID: ");
						organization.setId(in.nextLong());			
						if (orgService.getEmployees(organization.getId()) != null)
						{
							System.out.println("Showing all employees");
							empListOp = orgService.getEmployees(organization.getId());
							empAll = empListOp.get();
							for(int i = 0; i < empAll.size();i++)
								System.out.println(empAll.get(i).toString());
						}
						else
						{
							System.out.println("No employees found!");
						}
						returnToMenu();
						break;

				case 19:
						organization = new Organization();
						System.out.println("Please enter Organization ID to search");
						System.out.print("ID: ");
						organization.setId(in.nextLong());
						if (orgService.getDepartments(organization.getId()) != null)
						{
							System.out.println("Showing all departments");
							depListOp = orgService.getDepartments(organization.getId());
							depAll = depListOp.get();
							for(int i = 0; i < depAll.size();i++)
								System.out.println(depAll.get(i).toString());
						}
						else
						{
							System.out.println("No departments found!");
						}
						returnToMenu();
						break;

				case 20:
						if (orgService.getOrganizations() != null)
						{
							System.out.println("Showing all organizations");
							orgListOp = orgService.getOrganizations();
							orgAll = orgListOp.get();
							for(int i = 0; i < orgAll.size();i++)
								System.out.println(orgAll.get(i).toString());
						}
						else
						{
							System.out.println("No organizations found!");
						}
						returnToMenu();
						break;
					
				case 21:
						System.out.println("Exiting program");
						isRunning = false;
						break;
				
				default: 
						System.out.println("Please enter a valid option. Press Enter key to continue");
						try
						{
							System.in.read();
						}  
						catch(Exception e)
						{} 
						break;
							
			}
			
		}
		in.close();
	}
	
	public static void returnToMenu()
	{
		System.out.println("Returning to menu. Press Enter key to continue");
		try
		{
			System.in.read();
		}  
		catch(Exception e)
		{} 	
	}

}
