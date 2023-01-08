export class Client{
    id?: number;
    idType: string;
    name : string;
    lastname : string;
    document : number;
    email : string;
    birthDate : Date;
    creationDate: Date;
    updateDate: Date;
    updateUser : string;
    constructor(idType : string, name : string, lastname : string,
        document:number, email:string, birthDate : Date, creationDate : Date,
        updateUser : string, updateDate : Date){
            this.idType = idType;
            this.name = name;
            this.lastname = lastname;
            this.document = document;
            this.email = email;
            this.birthDate = birthDate;
            this.creationDate = creationDate;
            this.updateDate = updateDate;
            this.updateUser = updateUser;
    }
}