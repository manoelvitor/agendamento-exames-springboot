package com.projeto.controllerview;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.model.AgendaExame;
import com.projeto.model.Exame;
import com.projeto.service.AgendaExameService;
import com.projeto.service.ExameService;

@Controller
public class AgendaControllerView {

	@Autowired
	private AgendaExameService service;

	@Autowired
	private ExameService exService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/listarAgenda", method = RequestMethod.GET) // CAMINHO PARA ACIONAR O METODO, METODO DE																			// REQUISIÇÃO GET
	public ModelAndView getAgenda() { // CLASSE DO TIPO ModelAndView RETORNARÁ O MODEL E VIEW: OU SEJA DADOS DO BANCO
		ModelAndView mv = new ModelAndView("listarAgenda");// E OS TEMPLATES HTML
		List<AgendaExame> getAgenda = service.findAll(); // para retornar todas as linhas do banco de dados, em forma de
															// // lista
		mv.addObject("listarAgenda", getAgenda);
		return mv;
	}

	@RequestMapping(value = "/listarAgenda/{id}", method = RequestMethod.GET)
	public ModelAndView detalhesExame(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("detalhesExame");
		AgendaExame detalhes = service.getId(id).get(); // é necessario usar o metodo get para ter acesso no thymeleaf
		mv.addObject("detalhes", detalhes);
		return mv;
	}

	@RequestMapping(value = "/agendarExame", method = RequestMethod.GET)
	public ModelAndView agendarExame() {
		ModelAndView mv = new ModelAndView("agendarExame");
		List<Exame> getExame = exService.findAll();
		mv.addObject("agendarExame", getExame);
		return mv;
	}

	@RequestMapping(value = "/novoAgendamento", method = RequestMethod.POST)
	public String salvarAgendamento(AgendaExame agenda) {
		service.create(agenda);
		return "redirect:/agendarExame";
	}

}
