import {Component, OnInit} from "@angular/core";
import {Responsavel} from "../../../../model/responsavel.model";
import {FormControl, Validators} from "@angular/forms";
import {ResponsavelService} from "../../../../service/responsavel.service";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-reponsavelDeletar',
  templateUrl: './responsavel-deletar.component.html',
  styleUrls: ['./responsavel-deletar.component.css']
})
export class ResponsavelDeletarComponent implements OnInit {

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

  cancel(): void {
    this.router.navigate(['responsavel'])
  }

  encontrarPorId(): void {
    this.service.encontrarPorId(this.id_resp).subscribe(resposta => {
      this.responsavel = resposta;
    })
  }


  deletar(): void {
    this.service.deletar(this.responsavel).subscribe((res) => {
      this.router.navigate([''])
      this.service.message('Responsavel excluído com sucesso!')
    }, erro => {
      if (erro.error.error.match('já excluído')) {
        this.service.message(erro.error.error)
      }
    })
  }

  errorValidSetor() {
    if (this.setor.invalid) {
      return 'O nome deve ter entre 5 e 100 caracteres!';
    }
    return false;
  }


}
