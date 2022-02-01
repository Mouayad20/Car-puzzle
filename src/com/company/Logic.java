package com.company;

import java.util.*;

public class Logic {

    Scanner scanner = new Scanner(System.in);

    List<State> userCommand(State state) throws CloneNotSupportedException {
        //  1    11   12  18  20  22  24  35

        State currentState = state.clone();
        List<State> states = new ArrayList<>();

        System.out.println("IS Finish   :: " + currentState.isFinish());
        while (true) {
            List<State> nextStates = currentState.nextStates();
            for (int i = 0; i < nextStates.size(); i++) {
                System.out.println("___________" + nextStates.get(i).getId() + "_______________");
                nextStates.get(i).show();
            }
            System.out.print("\nEnter your choice id :: ");
            int id = scanner.nextInt();
            for (int i = 0; i < nextStates.size(); i++) {
                if (nextStates.get(i).getId() == id) {
                    states.add(nextStates.get(i));
                    currentState = nextStates.get(i).clone();
                }
            }
            if (currentState.getCells()[2][5].getCar() != null && currentState.getCells()[2][5].getCar().isMain_car() && currentState.getCells()[2][6].getCar().isMain_car()) {
                System.out.println("\n\n\n\n\t\t\t\t******************************\n\n\n\n");
                break;
            }
        }
        System.out.println("\t\tYou Win  \n And Your Path is :: \n");
        for (int i = 0; i < states.size(); i++) {
            System.out.println("___________" + states.get(i).getId() + "_______________");
            states.get(i).show();
        }

        return states;
    }

    List<State> DFS(State InitState) throws CloneNotSupportedException {

        List<State> states = new ArrayList<>();
        Stack<State> stack = new Stack<State>();
        Map<String, State> map = new HashMap<String, State>();

        State currentState = InitState.clone();

        stack.push(currentState);
        map.put(currentState.hashing(), currentState);

        while (!stack.isEmpty()) {

            currentState = stack.pop();

            if (currentState.getCells()[2][5].getCar() != null && currentState.getCells()[2][5].getCar().isMain_car() && currentState.getCells()[2][6].getCar().isMain_car()) {
                State tempo = currentState;
                while (tempo != null) {
                    states.add(tempo);
                    tempo = tempo.getParent();
                }
                break;
            }

            List<State> nextStates = currentState.nextStates();
            for (State state : nextStates) {
                if (!map.containsKey(state.hashing())) {
                    map.put(state.hashing(), state);
                    stack.push(state);
                }
            }
        }
        System.out.println("developer nodes      ::    " + map.size());
        return states;
    }

    List<State> BFS(State InitState) throws CloneNotSupportedException {

        List<State> states = new ArrayList<>();
        Queue<State> queue = new LinkedList<State>();
        Map<String, State> map = new HashMap<String, State>();

        queue.add(InitState);
        State currentState = InitState.clone();
        map.put(currentState.hashing(), currentState);

        while (!queue.isEmpty()) {

            currentState = queue.remove();

            if (currentState.getCells()[2][5].getCar() != null && currentState.getCells()[2][6].getCar() != null) {
                if (currentState.getCells()[2][5].getCar().isMain_car() && currentState.getCells()[2][6].getCar().isMain_car()) {
                    State tempo = currentState;
                    while (tempo != null) {
                        states.add(tempo);
                        tempo = tempo.getParent();
                    }
                    break;
                }
            }
            List<State> nextStates = currentState.nextStates();
            for (State state : nextStates) {
                if (!map.containsKey(state.hashing())) {
                    map.put(state.hashing(), state);
                    queue.add(state);
                }
            }
        }
        System.out.println("developer nodes      ::    " + map.size());
        return states;
    }

    List<State> UCS(State InitState) throws CloneNotSupportedException {

        List<State> states = new ArrayList<>();
        PriorityQueue<State> queue = new PriorityQueue<>();
        Map<String, State> map = new HashMap<String, State>();

        queue.add(InitState);
        State currentState = InitState.clone();
        map.put(currentState.hashing(), currentState);

        while (!queue.isEmpty()) {

            currentState = queue.remove();

            if (currentState.getCells()[2][5].getCar() != null && currentState.getCells()[2][6].getCar() != null) {
                if (currentState.getCells()[2][5].getCar().isMain_car() && currentState.getCells()[2][6].getCar().isMain_car()) {
                    State tempo = currentState;
                    while (tempo != null) {
                        states.add(tempo);
                        tempo = tempo.getParent();
                    }
                    break;
                }
            }
            List<State> nextStates = currentState.nextStates();
            for (State state : nextStates) {
                if (!map.containsKey(state.hashing())) {
                    map.put(state.hashing(), state);
                    queue.add(state);
                }
            }
        }
        System.out.println("developer nodes      ::    " + map.size());
        return states;
    }

    List<State> AStar(State InitState) throws CloneNotSupportedException {

        List<State> states = new ArrayList<>();
        PriorityQueue<State> queue = new PriorityQueue<>();
        Map<String, State> map = new HashMap<String, State>();

        queue.add(InitState);
        State currentState = InitState.clone();
        map.put(currentState.hashing(), currentState);

        while (!queue.isEmpty()) {

            currentState = queue.remove();
            currentState.setCost(currentState.getCost() - currentState.heuristic() );


            if (currentState.getCells()[2][5].getCar() != null && currentState.getCells()[2][6].getCar() != null) {
                if (currentState.getCells()[2][5].getCar().isMain_car() && currentState.getCells()[2][6].getCar().isMain_car()) {
                    State tempo = currentState;
                    while (tempo != null) {
                        states.add(tempo);
                        tempo = tempo.getParent();
                    }
                    break;
                }
            }
            List<State> nextStates = currentState.nextStates();
            for (State state : nextStates) {
                if (!map.containsKey(state.hashing())) {
                    map.put(state.hashing(), state);
                    state.setCost(state.getCost() + state.heuristic() );
                    queue.add(state);
                }
            }
        }
        System.out.println("developer nodes      ::    " + map.size());
        return states;
    }

}