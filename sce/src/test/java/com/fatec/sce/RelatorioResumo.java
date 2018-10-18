package com.fatec.sce;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class RelatorioResumo {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTests.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("Total de Casos de Teste: " + result.getRunCount());
		System.out.println("Falhas encontradas:" + result.getFailureCount());
	}
}