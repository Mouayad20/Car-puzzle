package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
/*

            >>>>>>   Final result  <<<<<<
            __________________________
                    BFS
            developer nodes      ::    10304
            solution path length ::      7
            __________________________
                    DFS
            developer nodes      ::    9073
            solution path length ::     11
            __________________________
                    UCS
            developer nodes      ::    7216
            solution path length ::     7
            __________________________
                    AStar
            developer nodes      ::    4335
            solution path length ::      7
            __________________________

 */

        State initState = Static.getLevelOne().clone();

        Logic logic = new Logic();

        System.out.println("__________________________");
        System.out.println("\t\tBFS");
        List<State> BFS = logic.BFS(initState.clone());
        System.out.println("solution path length ::     "+BFS.size());
        System.out.println(BFS);
        System.out.println("__________________________");
        System.out.println("\t\tDFS");
        List<State> DFS = logic.DFS(initState.clone());
        System.out.println("solution path length ::     "+DFS.size());
        System.out.println(DFS);
        System.out.println("__________________________");
        System.out.println("\t\tUCS");
        List<State> UCS = logic.UCS(initState.clone());
        System.out.println("solution path length ::     "+UCS.size());
        System.out.println(UCS);
        System.out.println("__________________________");
        System.out.println("\t\tAStar");
        List<State> AStar = logic.AStar(initState.clone());
        System.out.println("solution path length ::     "+AStar.size());
        System.out.println(AStar);
        System.out.println("__________________________");

    }
}