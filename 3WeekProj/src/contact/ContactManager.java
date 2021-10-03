package contact;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager 
{
	ArrayList<Contact> contacts = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	
	// 다음 함수를 채우시오. input 파일에 있는 내용을 입력
	public void ReadAll() 
	{
		String phoneNumber;
		while(true)
		{
			if((phoneNumber = scan.next()).equals("end"))
				break;
			Contact contact = new Contact(phoneNumber);
			contact.Read(scan);
			contacts.add(contact);
		}
	}
	
	public void PrintList() 
	{
		if (contacts.isEmpty()) 
		{
			System.out.println("연락처가 비어있습니다.");
			return;
		}
		int i = 0;
		for (Contact c: contacts)
			c.Show(i++);
	}
	
	public void RegisterContact() 
	{
		String phone = null;
		System.out.print("전화번호 : ");
		phone = scan.next();
		if (FindContact(phone) != null) 
		{
			System.out.println("이미 존재하는 전화번호 입니다.");
			return;
		}
		Contact c = new Contact(phone);
		c.ReadRegister(scan);	
		contacts.add(c);
	}
	
	public void DeleteContact() 
	{
		PrintList();
		int index = -1;
		System.out.print("삭제할 번호: ");
		index = scan.nextInt();
		if (index <= 0 || index > contacts.size()) 
		{
			System.out.println("번호가 범위를 벗어났습니다.");
			return;
		}
		contacts.remove(index-1);
	}
	
	// 다음 함수를 채우시오.
	public void ModifyContact() 
	{
		System.out.print("수정할 번호: ");
		int index = scan.nextInt();
		Contact targetContact = contacts.get(index);
		targetContact.Modify(scan);
		targetContact.Show(index);
	}
	
	// 다음 함수를 채우시오.
	public void SearchContact() 
	{
		scan.nextLine();
		System.out.print("검색 키워드: ");
		String keyWord = scan.nextLine();
		int index = 1;
		for(Contact c : contacts)
		{
			if(c.Matches(keyWord))
			{
				c.Show(index);
			}
			index++;
		}
	}
	
	// findContact 함수를 만드시오.
	public Contact FindContact(String search)
	{
		for(Contact c : contacts)
		{
			if(c.Matches(search))
			{
				return c;
			}
		}
		return null;
	}
	
	public void Clean()
	{
		scan.close();
	}
}
