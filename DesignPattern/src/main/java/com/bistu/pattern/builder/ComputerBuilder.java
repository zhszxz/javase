package com.bistu.pattern.builder;

public class ComputerBuilder {

    private Computer computer;

    public ComputerBuilder(Computer computer) {
        this.computer = computer;
    }

    public ComputerBuilder cpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder memory(String memory) {
        computer.setMemory(memory);
        return this;
    }

    public ComputerBuilder hardDisk(String hardDisk) {
        computer.setHardDisk(hardDisk);
        return this;
    }

    public Computer bulid() {
        return computer;
    }
}
