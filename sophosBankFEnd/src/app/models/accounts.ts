import { Client } from "./client";

export class Accounts{
    id?: number;
    acc_id? : number;
    client : Client;
    accNumber : string;
    acc_type : string;
    balance : number;
    created_at: Date;
    updated_at : Date;
    acc_status: string;

    constructor(acc_id : number, client: Client, accNumber : string,acc_type : string,
        balance : number, created_at: Date, updated_at: Date, acc_status: string){
         
            this.acc_id = acc_id;
            this.client = client;
            this.accNumber = accNumber;
            this.acc_type = acc_type;
            this.balance = balance;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.acc_status = acc_status;
    }


   

    
}