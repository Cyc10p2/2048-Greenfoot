import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Actor
{
    public Box(int value)
    {
        if(value!=0) {
            spawnBox(value);
        }
    }

    public void act() 
    {

    }

    public void spawnBox(int value)
    {   
        while (value == 2)
        {
            setImage("2.png");
            break;
        }
        while (value == 4)
        {
            setImage("4.png");
            break;
        }
        while (value == 8)
        {
            setImage("8.png");
            break;
        }
        while (value == 16)
        {
            setImage("16.png");
            break;
        }
        while (value == 32)
        {
            setImage("32.png");
            break;
        }
        while (value == 64)
        {
            setImage("64.png");
            break;
        }
        while (value == 128)
        {
            setImage("128.png");
            break;
        }
        while (value == 256)
        {
            setImage("256.png");
            break;
        }
        while (value == 512)
        {
            setImage("512.png");
            break;
        }
    }
} 