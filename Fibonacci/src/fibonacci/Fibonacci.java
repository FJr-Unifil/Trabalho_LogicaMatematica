package fibonacci;

import java.util.Scanner;

public class Fibonacci {

	public static void iterativo(int n) {
		int anteriorDaAnterior = 0, anterior = 1, atual = 0, i = 2;
		int numeroOperacoes = 0;
		if (n == 0 || n == 1) {
			System.out.println("O valor de Fibonacci de n: " + n + "é igual a: " + n);
		} else {
			while (i <= n) {
				atual = anteriorDaAnterior + anterior;
				numeroOperacoes++;
				anteriorDaAnterior = anterior;
				anterior = atual;
				i = i + 1;
				numeroOperacoes++;
			}
			System.out.println("Numero operacoes (iterativo): " + numeroOperacoes);
			System.out.println("O valor de Fibonacci de n: " + n + " é igual a: " + atual);
		}

	}

	public static int recursivo(int n) {
		if (n == 1) {
			return 1;
		} else {
			if (n == 2) {
				return 1;
			} else {
				return recursivo(n - 2) + recursivo(n - 1);
			}
		}
	}

	public static void main(String[] args) {
		int n, ultimoFibonacci;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insira o valor de n para cálculo do Fibonacci: ");
		n = scanner.nextInt();

		// parte do iterativo

		long startIterativo = System.nanoTime();
		iterativo(n);
		long endIterativo = System.nanoTime();
		long durationIterativo = endIterativo - startIterativo;
		System.out.println("Duração iterativo em nano segundos = " + durationIterativo);

		// parte do recursivo
		long startRecursivo = System.nanoTime();
		ultimoFibonacci = recursivo(n);
		long endRecursivo = System.nanoTime();
		long duration = endRecursivo - startRecursivo;
		System.out.println("Valor de fibonacci recursivo igual a: " + ultimoFibonacci);
		System.out.println("Tempo recursivo = " + duration);
		scanner.close();
	}

}
