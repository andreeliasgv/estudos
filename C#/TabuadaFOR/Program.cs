using System;

public class Program
{
    public static void Main()
    {
        Console.WriteLine("TABUADA");
        Console.WriteLine("Digite um número para exibir a tabuada: ");
        Console.Write("> ");
        
        int numero = Convert.ToInt32(Console.ReadLine());

        Console.WriteLine();

        Console.WriteLine($"TABUADA DO {numero}:");

        Console.WriteLine();

        for (int i = 0; i <= 10; i++)
        {
            Console.WriteLine($"{i} x {numero} = {i * numero}");
        }
        Console.WriteLine();
    }
}