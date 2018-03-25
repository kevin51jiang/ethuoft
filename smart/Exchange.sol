pragma solidity ^0.4.20;

contract Exchange {
    address buyer;
    
    //Price of the item in finneys
    uint priceOfItem;
    uint halfPriceOfItem;
    
    
    function Exchange(address _seller, address buyerAddress, uint itemPriceFinney) payable public{
        //Set the buyer
        buyer = msg.sender;
        buyer = buyerAddress;
        
        //Half the price of the item in finneys
        priceOfItem = itemPriceFinney;
        halfPriceOfItem = itemPriceFinney / 2;
        
        // Send 50% of priceOfItem to _seller
        _seller.transfer(halfPriceOfItem * 10**15);
    }
    
    //Sends an x number of ether
    function sendEth(address _seller, uint numFinney) payable public{
        // Sends the seller num finneys
        _seller.transfer(numFinney * 10**15);
    }
    
    
    function() public payable {}
    
}