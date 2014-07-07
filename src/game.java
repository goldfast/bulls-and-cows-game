import java.util.Scanner;

public class game 
	{
		private void StartGame()
			{
				System.out.println("Игра Быки и коровы");
				System.out.println("Вам нужно отгадать 4-ре числа");
			}
		private void ResultGame(int BullNum, int CowNum)
			{
				System.out.println("Результат:");
				System.out.println(BullNum+"Б");
				System.out.println(CowNum+"К");
			}
		private void NewGame()
			{
				System.out.println("Старт!");
			}
		private void WinGame()
			{
				System.out.println("Вы выиграли, Желаете еще раз сыграть?");
				System.out.println("Для начала новой игры нажмите '1' ");
				System.out.println("Либо другую цифру для выхода!");
			}
		private void ExitGame()
			{
				System.out.println("Довстречи в новой игре ;)");
			}
		private boolean BodyGame(Scanner scod, int[] SecretCode)
			{
				int[] UserCode = new int[4];
				int CowNum=0, BullNum=0, Iinc=0;
				boolean Game=true;
				for(int i=0; i<4; i++)
					{
						Iinc=i+1;
						System.out.println("Введите число №"+ Iinc +" = ");
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
