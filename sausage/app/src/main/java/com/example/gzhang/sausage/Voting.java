package com.example.gzhang.sausage;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class Voting extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b604051610472380380610472833981016040528080519091019050600181805161003d929160200190610044565b50506100d2565b82805482825590600052602060002090810192821561009b579160200282015b8281111561009b5782518254600160a060020a031916600160a060020a039190911617825560209290920191600190910190610064565b506100a79291506100ab565b5090565b6100cf91905b808211156100a7578054600160a060020a03191681556001016100b1565b90565b610391806100e16000396000f3006060604052600436106100775763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166330c880c3811461007c5780634041ef54146100b157806371851be8146100d0578063b13c744b14610103578063c668561714610135578063c6fcb2b714610157575b600080fd5b341561008757600080fd5b61009b600160a060020a036004351661017e565b60405160ff909116815260200160405180910390f35b34156100bc57600080fd5b61009b600160a060020a0360043516610193565b34156100db57600080fd5b6100ef600160a060020a03600435166101c8565b604051901515815260200160405180910390f35b341561010e57600080fd5b610119600435610226565b604051600160a060020a03909116815260200160405180910390f35b341561014057600080fd5b610119600160a060020a036004351660243561024e565b341561016257600080fd5b61017c600160a060020a0360043581169060243516610285565b005b60006020819052908152604090205460ff1681565b600061019e826101c8565b15156101a957600080fd5b50600160a060020a031660009081526020819052604090205460ff1690565b6000805b60015481101561021b5782600160a060020a03166001828154811015156101ef57fe5b600091825260209091200154600160a060020a031614156102135760019150610220565b6001016101cc565b600091505b50919050565b600180548290811061023457fe5b600091825260209091200154600160a060020a0316905081565b60026020528160005260406000208181548110151561026957fe5b600091825260209091200154600160a060020a03169150829050565b61028e826101c8565b151561029957600080fd5b600160a060020a038216600090815260208181526040808320805460ff198116600160ff92831681019092161790915560029092529091208054909181016102e1838261031b565b506000918252602090912001805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a039290921691909117905550565b81548183558181151161033f5760008381526020902061033f918101908301610344565b505050565b61036291905b8082111561035e576000815560010161034a565b5090565b905600a165627a7a72305820cd07183f287a76bc8dadd78ebd46afab5c2d31b65894364049d1d10a015c12620029";

    protected Voting(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Voting(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> votesReceived(String param0) {
        final Function function = new Function("votesReceived", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> totalVotesFor(String candidate) {
        final Function function = new Function("totalVotesFor", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(candidate)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> validCandidate(String candidate) {
        final Function function = new Function("validCandidate", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(candidate)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<String> candidateList(BigInteger param0) {
        final Function function = new Function("candidateList", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> record(String param0, BigInteger param1) {
        final Function function = new Function("record", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Uint256(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> voteForCandidate(String candidate, String voter) {
        final Function function = new Function(
                "voteForCandidate", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(candidate), 
                new org.web3j.abi.datatypes.Address(voter)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Voting> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, List<String> candidateNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(Voting.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<Voting> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, List<String> candidateNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.Address.class))));
        return deployRemoteCall(Voting.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static Voting load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Voting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Voting load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Voting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
