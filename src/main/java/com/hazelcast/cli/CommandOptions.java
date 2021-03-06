package com.hazelcast.cli;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import java.util.Arrays;

/**
 * Created by mefeakengin on 1/19/16.
 */
public class CommandOptions {

    static OptionParser optionParser = new OptionParser();
    static OptionSpec help = optionParser.acceptsAll(Arrays.asList("help", "h"));
    static OptionSpec exit = optionParser.acceptsAll(Arrays.asList("exit", "e"));
    static OptionSpec removeMachine = optionParser.acceptsAll(Arrays.asList("remove-machine")).withOptionalArg().ofType(String.class);
    static OptionSpec listMachines = optionParser.acceptsAll(Arrays.asList("list-machines"));

    static OptionSpec install = optionParser.acceptsAll(Arrays.asList("install", "i")).withOptionalArg().ofType(String.class);
    static OptionSpec startMember = optionParser.acceptsAll(Arrays.asList("S", "start-member")).withOptionalArg().ofType(String.class);
    static OptionSpec startManagementCenter = optionParser.acceptsAll(Arrays.asList("start-mc", "management-center"));
    static OptionSpec version = optionParser.acceptsAll(Arrays.asList("v", "version")).withRequiredArg().ofType(String.class);

    //Options of operations
    static OptionSpec optionNodeName = optionParser.acceptsAll(Arrays.asList("t", "tag")).withRequiredArg().ofType(String.class);
    static OptionSpec optionConfigFile = optionParser.acceptsAll(Arrays.asList("C", "config-file")).withRequiredArg().ofType(String.class);

    //Options for cluster operations
    static OptionSpec shutdownCluster = optionParser.acceptsAll(Arrays.asList("cluster-shutdown", "S"));
    static OptionSpec killMember = optionParser.acceptsAll(Arrays.asList("k", "kill-member")).withOptionalArg().ofType(String.class);
    static OptionSpec listMember = optionParser.acceptsAll(Arrays.asList("l", "list-member"));
    static OptionSpec getClusterState = optionParser.acceptsAll(Arrays.asList("cluster-state"));
    static OptionSpec changeClusterState = optionParser.acceptsAll(Arrays.asList("cluster-change-state")).withOptionalArg().ofType(String.class);
    static OptionSpec changeClusterSettings = optionParser.acceptsAll(Arrays.asList("cluster-change-settings")).withOptionalArg().ofType(String.class);
    static OptionSpec createCluster = optionParser.acceptsAll(Arrays.asList("create-cluster"));
    static OptionSpec forceStart = optionParser.acceptsAll(Arrays.asList("cluster-force-start"));
    static OptionSpec clusterDisconnect = optionParser.acceptsAll(Arrays.asList("cluster-disconnect"));

    public OptionSet parse(String input) throws Exception {

        String[] inputArray = input.trim().split("[ \t]+");
        try {
            return this.optionParser.parse(inputArray);
        } catch (Exception e) {
            //TODO: Check if works/
            return this.parse("");
        }
    }

}
