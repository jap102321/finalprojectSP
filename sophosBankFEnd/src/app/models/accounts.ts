import { Client } from "./client";

export class Accounts{
    acc_id? : number;
    client:Client;
    client_id: number;
    accNumber : string;
    acc_type : string;
    balance : number;
    created_at: Date;
    updated_at : Date;
    acc_status: string;

    constructor(client : Client, accNumber : string,acc_type : string,
        balance : number, created_at: Date, updated_at: Date, acc_status: string){         
            this.client = client;
            this.accNumber = accNumber;
            this.acc_type = acc_type;
            this.balance = balance;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.acc_status = acc_status;
    }


   

    
}