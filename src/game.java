import java.util.Scanner;

public class game 
	{
		private void StartGame()
			{
				System.out.println("���� ���� � ������");
				System.out.println("��� ����� �������� 4-�� �����");
			}
		private void ResultGame(int BullNum, int CowNum)
			{
				System.out.println("���������:");
				System.out.println(BullNum+"�");
				System.out.println(CowNum+"�");
			}
		private void NewGame()
			{
				System.out.println("�����!");
			}
		private void WinGame()
			{
				System.out.println("�� ��������, ������� ��� ��� �������?");
				System.out.println("��� ������ ����� ���� ������� '1' ");
				System.out.println("���� ������ ����� ��� ������!");
			}
		private void ExitGame()
			{
				System.out.println("��������� � ����� ���� ;)");
			}
		private boolean BodyGame(Scanner scod, int[] SecretCode)
			{
				int[] UserCode = new int[4];
				int CowNum=0, BullNum=0, Iinc=0;
				boolean Game=true;
				for(int i=0; i<4; i++)
					{
						Iinc=i+1;
						System.out.println("������� ����� �"+ Iinc +" = ");
						UserCode[i] = scod.nextInt();
					}
				for(int i=0; i<4; i++)
					{
						if(SecretCode[i]==UserCode[i]){BullNum++;}
						for(int k=0; k<4; k++)
							{
								if(SecretCode[i]==UserCode[k]){CowNum++;}
							}
					}
				CowNum-=BullNum;
				if(BullNum==4){Game=false;}
				ResultGame(BullNum, CowNum);
				return Game;
			}
		private void ProcessGame(int[] SecretCode)
			{
				boolean Game=true;
				boolean GameNew = true;
				Scanner scod = new Scanner(System.in);
				StartGame();
				while(GameNew==true)
					{
						NewGame();
						while(Game==true)
							{
								Game=BodyGame(scod, SecretCode);
							}
						WinGame();
						if(scod.nextInt()!=1)
							{
								GameNew = false;
								ExitGame();
							}
						else{Game=true;}
					}
			}
		public void Game(int[] SecretCode)
			{
				ProcessGame(SecretCode);
			}
	}
