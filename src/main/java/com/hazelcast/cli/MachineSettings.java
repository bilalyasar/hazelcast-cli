package com.hazelcast.cli;

import joptsimple.OptionSet;

import java.util.Set;

public class MachineSettings {

    public final String machineName;
    public final String userName;
    public final String hostIp;
    public final int sshPort;
    public final String remotePath;
    public final String identityPath;

    public MachineSettings(String machineName, String userName, String hostIp, String remotePath, String identityPath) {

        this.machineName = machineName;
        this.userName = userName;
        this.hostIp = hostIp;
        this.sshPort = 22;
        this.remotePath = remotePath;
        this.identityPath = identityPath;

    }

    public static MachineSettings getMachine(OptionSet result, Set<MachineSettings> machines, String machineName) {
        MachineSettings machine = null;

        if(machineName == null) {
            System.out.println("No machine name is given.");
        }

        boolean machineExists = false;
        for (MachineSettings currentMachine : machines) {
            if(currentMachine.machineName.equals(machineName)) {
                machine = currentMachine;
                machineExists = true;
                break;
            }
        }
        if (!machineExists) {
            if(machineName != null) {
                System.out.println("Machine with the name " + machineName + " does not exist.");
            } else {
                System.out.println("Please enter a valid machine name.");
            }
            return null;
        } else {
            return machine;
        }
    }

}
