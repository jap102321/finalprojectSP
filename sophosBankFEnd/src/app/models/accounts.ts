import { Client } from "./client";
import { Transaction } from "./transaction";

export class Accounts{
    accid? : number;
    client:Client;
    accNumber : string;
    acc_type : string;
    balance : number;
    created_at: Date;
    updated_at : Date;
    acc_status: string;
    transaction : Transaction;

    constructor(client : Client, accNumber : string,acc_type : string,
        balance : number, created_at: Date, updated_at: Date, acc_status: string, transaction : Transaction){         
            this.client = client;
            this.accNumber = accNumber;
            this.acc_type = acc_type;
            this.balance = balance;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.acc_status = acc_status;
            this.transaction = transaction
    }


   

    
}