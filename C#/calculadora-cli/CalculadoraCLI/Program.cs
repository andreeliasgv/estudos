using System;

class Program
{
    static void Main(String[] args)
    {
        Console.WriteLine("CALCULADORA CLI");
        Console.WriteLine("Escolha a operação:");
        Console.WriteLine("1 - Adição");
        Console.WriteLine("2 - Subtração");
        Console.WriteLine("3 - Multiplicação");
        Console.WriteLine("4 - Divisão");

        Console.WriteLine();
        Console.Write("> ");
        int operacao = Convert.ToInt32(Console.ReadLine());
        Console.WriteLine();

        Console.Write("Operação escolhida: ");
        switch (operacao)
        {
            case 1: Console.WriteLine("Adição"); break;
            case 2: Console.WriteLine("Subtração"); break;
            case 3: Console.WriteLine("Multiplicação"); break;
            case 4: Console.WriteLine("Divisão"); break;
            default: Console.WriteLine("Operação inválida"); break;
        }

        Console.WriteLine("Digite o primeiro número:");
        Console.Write("> ");
        int numero1 = Convert.ToInt32(Console.ReadLine());
        Console.WriteLine();
        Console.WriteLine("Digite o segundo número:");
        Console.Write("> ");
        int numero2 = Convert.ToInt32(Console.ReadLine());

        Console.WriteLine();

        Console.WriteLine("Calculando...");

        Console.WriteLine();

        switch (operacao)
        {
            case 1: Console.WriteLine($"{numero1} + {numero2} = {numero1 + numero2}"); break;
            case 2: Console.WriteLine($"{numero1} - {numero2} = {numero1 - numero2}"); break;
            case 3: Console.WriteLine($"{numero1} x {numero2} = {numero1 * numero2}"); break;
            case 4:
                if (numero2 != 0)
                {
                    Console.WriteLine($"{numero1} / {numero2} = {(double)numero1 / numero2}");
                }
                
                else
                {
                    Console.WriteLine("Erro: Divisão por zero não é permitida.");
                } break;
        }
    }
}