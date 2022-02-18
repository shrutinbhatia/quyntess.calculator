package com.quyntess.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quyntess.model.MyCalculator;
import com.quyntess.model.Response;
import com.quyntess.repository.MyCalcRepository;
import com.quyntess.service.MyCalcService;



@WebServlet("/calculate")
public class CalculatorController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse res) throws ServletException, IOException {
	
    MyCalculator myCalc = new MyCalculator();
    MyCalculator myCalc2 = new MyCalculator();
    MyCalcService myCalcService = new MyCalcService();
    MyCalcRepository myCalcRepository = new MyCalcRepository();
    String body = request.getReader().lines().collect(Collectors.joining());
    ObjectMapper mapper = new ObjectMapper();

    JsonNode rootNode = mapper.readTree(body);

      myCalc.setMyFormula(rootNode.get("question1").textValue());
      myCalc2.setMyFormula(rootNode.get("question2").textValue());



      myCalc.setResult(myCalcService.getResult(myCalc.getMyFormula()));
      myCalc2.setResult(myCalcService.getResult(myCalc2.getMyFormula()));
      myCalc.setMySeq(myCalcRepository.insertRecord(myCalc));
      myCalc2.setMySeq(myCalcRepository.insertRecord(myCalc2));
      PrintWriter out = res.getWriter();
      res.setContentType("application/json");
      res.setHeader("Access-Control-Allow-Origin", "*");
      Response response = new Response();
      response.setQuestion1(myCalc.getMyFormula());
      response.setResult1(myCalc.getResult());
      response.setQuestion2(myCalc2.getMyFormula());
      response.setResult2(myCalc2.getResult());
      res.setCharacterEncoding("UTF-8");
      
      String resultString= mapper.writeValueAsString(response);
      out.print(resultString);
      out.close();
    }

	 

}
