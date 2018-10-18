package com.challenge.soundcloud.Server;

public abstract class ServerAbstract implements Runnable{
    /* The abstract means that the class cannot be instantiated, only a subclassed.
      Runnable is used because the instance of the server is going to be executed by a thread.
    */
    public abstract void run();
}
