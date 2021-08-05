import {Component} from '@angular/core';
import {Tarefa} from './model/tarefa.model';
import {Comentario} from './model/comentario.model';
import {Responsavel} from './model/responsavel.model';
import {TipoTarefa} from './model/tipoTarefa.model';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  tituloPai: string = 'Titulo Pai';

  title = 'bsb-turma';

  tarefaSalva = new Tarefa();

  mostrarTarefaCriada(event: Tarefa): void {
    this.tarefaSalva = event;


  }

  descricaoPai: string = "Descricao Pai";

  descricao = 'bsb-turma';

  comentarioSalvo = new Comentario();

  mostrarComentarioCriado(event: Comentario): void {
    this.comentarioSalvo = event;
  }

  setorPai: string = "Setor Pai";

  setor = 'bsb-turma';

  responsavelSalvo = new Responsavel();

  mostrarResponsavelCriado(event): void {
    this.responsavelSalvo = event;

  }

  descricaoTipoTarefaPai: string = "DescricaoTipoTarefa Pai";

  descricaoTipoTarefa = 'bsb-turma';

  tipoTarefaSalva = new TipoTarefa();

  mostrarTipoTarefaCriada(event: TipoTarefa): void {
    this.tipoTarefaSalva = event;
  }



}
