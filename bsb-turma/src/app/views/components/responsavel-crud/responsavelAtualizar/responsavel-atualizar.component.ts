import {Component, OnInit} from "@angular/core";
import {Responsavel} from "../../../../model/responsavel.model";
import {FormControl, Validators} from "@angular/forms";
import {ResponsavelService} from "../../../../service/responsavel.service";
import {ActivatedRoute,Router} from "@angular/router";





@Component({
  selector: 'app-reponsavelAtualizar',
  templateUrl: './responsavel-atualizar.component.html',
  styleUrls: ['./responsavel-atualizar.component.css']
})
export class ResponsavelAtualizarComponent implements OnInit {

  id_resp = ''

  responsavel: Responsavel = {
    id: '',
    setor: ''
  }


  setor = new FormControl('', [Validators.minLength(10)]);



  constructor(
    private router: Router,
    private service: ResponsavelService,
    private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.id_resp = this.route.snapshot.paramMap.get('id')!

    this.encontrarPorId();
  }



  update(): void {
 this.service.update(this.responsavel).subscribe((resposta)=> {
   this.router.navigate(['responsavel'])
   this.service.message('Responsavel atualizado com sucesso!')
 })
  }
  encontrarPorId(): void {
    this.service.encontrarPorId(this.id_resp).subscribe(resposta => {
      this.responsavel = resposta;
    })
  }

   cancel(): void {
     this.router.navigate(['responsavel'])
   }

  errorValidSetor() {
    if (this.setor.invalid) {
      return 'O nome deve ter entre 5 e 100 caracteres!';
    }
    return false;
  }
}
