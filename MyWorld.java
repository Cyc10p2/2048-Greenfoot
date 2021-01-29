import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int Temp[][] = new int[4][4];
    public Box B[][]= new Box[4][4];
    Counter count=new Counter();

    public void randomVal()
    {
        int X[] = new int[16];
        int Y[] = new int[16];
        int ifMove = 0;
        for(int i=0;i<4;i++)
        {
            for(int k=0;k<4;k++)
            {
                if(Temp[i][k]==0)
                {
                    X[ifMove]=i;
                    Y[ifMove]=k;
                    ifMove = ifMove + 1;
                }
            }
        }
        if(ifMove==0)
            return;

        int rand=0;
        if(Greenfoot.getRandomNumber(10)>2) {
            rand = 2;
        }
        else {
            rand = 4;
        }
        int k = Greenfoot.getRandomNumber(ifMove);
        Temp[X[k]][Y[k]] = rand; 
        B[X[k]][Y[k]] = new Box(rand);
        int x1=(Y[k])*134+77;
        int y1=(X[k])*134+77; 
        addObject(B[X[k]][Y[k]],x1,y1);
        printArray();
    }

    public MyWorld()
    {    
        super(550, 600, 1);
        addObject(count,275,575);
        int rand1 = Greenfoot.getRandomNumber(4);
        int rand2 = Greenfoot.getRandomNumber(4);

        for(int r1 = 0; r1<4; r1++) 
        {
            for(int r2 = 0; r2<4;r2++) {
                Temp[r1][r2] = 0;
                B[r1][r2] = new Box(Temp[r1][r2]);
            }
        }

        int coordinate = 77;

        int co1 =(rand2)*134 + coordinate;
        int co11 =(rand1)*139 + coordinate;
        int co2=(3-rand2)*134 + coordinate;
        int co22=(3-rand1)*139 + coordinate;

        B[rand1][rand2] = new Box(2);
        B[3-rand1][3-rand2] = new Box(2);

        addObject(B[rand1][rand2],co1,co11);
        addObject(B[3-rand1][3-rand2],co2,co22);
    }

    public void printArray()
    {   
        System.out.println(Temp[0][0] + " " + Temp[0][1] + " " + Temp[0][2] + " " + Temp[0][3]);
        System.out.println(Temp[1][0] + " " + Temp[1][1] + " " + Temp[1][2] + " " + Temp[1][3]);
        System.out.println(Temp[2][0] + " " + Temp[2][1] + " " + Temp[2][2] + " " + Temp[2][3]);
        System.out.println(Temp[3][0] + " " + Temp[3][1] + " " + Temp[3][2] + " " + Temp[3][3]);
        System.out.println(" ");
    }

    public void act() {
        String key = Greenfoot.getKey();
        if(key!=null)
        {

            if(key.equals("a"))
            {

            }

            else if(key.equals("d"))
            {

            }

            else if(key.equals("w"))
            {
                up();
            }

            else if(key.equals("s"))
            {

            }

            printArray(); 
            randomVal(); 

        }
    }

    public void up() {
        for(int i=1;i<=3;i++)
        {
            for(int j=3;j>=0;j--)
            {
                if(Temp[i][j]!=0)
                {   int k=i; 
                    while(k>0)
                    { 
                        int xCo=(j)*134+77;
                        int yCo=(k-1)*139+77;
                        if(Temp[k-1][j]==0)
                        {   Temp[k-1][j]=Temp[k][j];
                            B[k-1][j].spawnBox(Temp[k-1][j]);
                            addObject(B[k-1][j],xCo,yCo);

                            Temp[k][j]=0;
                            removeObjects(getObjectsAt(xCo,yCo+134,Box.class));
                            if(Temp[i][k-1]==512)

                            k--;
                        }

                        else if(Temp[k][j]==Temp[k-1][j])
                        {
                            Temp[k-1][j]*=2;
                            count.add(Temp[k-1][j]);
                            B[k-1][j].spawnBox(Temp[k-1][j]);
                            addObject(B[k-1][j],xCo,yCo);

                            Temp[k][j]=0;

                            removeObjects(getObjectsAt(xCo,yCo+134,Box.class));

                            k--;

                        }
                        else
                            k--;
                    }
                }

            }
        }
    }
}