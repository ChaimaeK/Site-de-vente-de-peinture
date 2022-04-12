import { Component, OnInit } from '@angular/core';
import {Client} from "../../Classes/client";
import {HttpClient} from "@angular/common/http";
import {ClientService} from "../../Services/client.service";
import {AuthenticationService} from "../../Services/authentication.service";
import {Car} from "../../Classes/car";
import {CarService} from "../../Services/car.service";

class Cars {
}

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.scss']
})
export class PanierComponent implements OnInit {

  users: Client[];
  cars;
  carsPanier;

  constructor(private http: HttpClient, private clientService: ClientService, private carService: CarService, public authService:AuthenticationService) {
  }

  private getCarsAll() {
    this.getCars("/vehicules");
  }

  private getCars(url) {
    this.clientService.getResource(this.clientService.host+url)
      .subscribe(data=>{
        this.cars=data;
        this.cars=this.cars._embedded.vehicules;
      },err=>{
        console.log(err);
      })
  }

  private getCarsPanier() {
    this.getCarsAll();
    this.cars.forEach(function(item){
      if(item.id==1){
        this.carsPanier.push(item)
      }
    });
  }

  ngOnInit() {
    if(this.authService.isAuthenticated()){
      this.clientService.getClients().subscribe(data => {
        this.users = data;
      });
      this.getCarsAll();
      this.getCarsPanier();

      // this.cars.forEach(function(item){
      //   if(item.id==1){
      //     this.carsPanier.push(item)
      //   }
      // });
    }
  }

  public supprimerClient(selectedClient : Client){
    this.clientService.deleteClient(selectedClient).subscribe();
    window.location.reload();
  }


}
