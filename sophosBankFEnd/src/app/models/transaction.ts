import { Accounts } from "./accounts";

export class Transaction{
    trans_id? : number;
    account : Accounts;
    transac_type : string;
    amount : number;
    transac_date : Date;


    constructor(account:Accounts, transac_type : string, amount : number, transac_date : Date ){
        this.account = account;
        this.transac_type = transac_type;
        this.amount = amount;
        this.transac_date = transac_date;
    }
}