package org.example;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
  private final long n;

  public FactorialTask(long n) {
    this.n = n;
  }

  @Override
  protected Long compute() {

    if(n <= 1)
      return n;

    FactorialTask factorialTask1 = new FactorialTask(n - 1);
    factorialTask1.fork();

    return n * factorialTask1.join();
  }
}
