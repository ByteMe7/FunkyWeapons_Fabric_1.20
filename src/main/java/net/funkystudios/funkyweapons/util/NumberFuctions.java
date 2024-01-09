package net.funkystudios.funkyweapons.util;

public class NumberFuctions {
    public static int random(int min, int max){
        return (int) ((Math.random()) * (max - min) +min);
    }
}
