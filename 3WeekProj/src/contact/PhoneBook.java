package contact;

public class PhoneBook 
{
	ContactManager contactManager = new ContactManager();
	
	public void Run() 
	{
		contactManager.ReadAll();
		runMenu();
		clean();
	}
	
	private void clean()
	{
		contactManager.Clean();
	}
	
	private int inputMenu() 
	{
		int num;
		while (true) 
		{
			System.out.println("############ 연락처 관리 ############");
			System.out.print("(1) 연락처 출력  ");
			System.out.print("(2) 새로 등록  ");
			System.out.print("(3) 삭제  ");
			System.out.print("(4) 검색  ");
			System.out.print("(5) 수정  ");
			System.out.print("(6) 끝내기  ");
			System.out.print("... ");
			num = contactManager.scan.nextInt();
			if (num >= 1 && num <= 6)
				return num;
			System.out.println("잘못된 번호입니다. 다시 입력해 주세요...");
		}
	}
	
	// inputMenu를 이용하여 메뉴를 입력받고 실행하도록 작성하시오.
	private void runMenu() 
	{
		boolean running=true;
		int input;
		while(running) 
		{
			input = inputMenu();
			switch (input) 
			{
			case 1:
				contactManager.PrintList();
				break;
			case 2:
				contactManager.RegisterContact();
				break;
			case 3:
				contactManager.DeleteContact();
				break;
			case 4:
				contactManager.SearchContact();
				break;
			case 5:
				contactManager.ModifyContact();
				break;
			case 6:
				running = false;
				break;
			default:
				System.out.printf("Invalied Value : [%d]\n", input);
				break;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		PhoneBook phoneBook = new PhoneBook();
		phoneBook.Run();
	}
}
