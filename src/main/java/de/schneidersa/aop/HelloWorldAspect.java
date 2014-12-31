package de.schneidersa.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Test Aspekt der beim Start der Anwendung und beim Beenden der Anwendung eine Meldung ausgibt
 *
 * @author Sandra Schneider
 */
@Aspect
public class HelloWorldAspect {

    /**
     * Behandle die Main Methode
     */
    @Pointcut("execution(* main(..))")
    public void definePointcut() {
    }

    /**
     * Ausgabe beim Start
     * @param joinPoint
     */
    @Before("definePointcut()")
    public void vorDemStart(JoinPoint joinPoint) {
        System.out.println("Viel Spass beim Spielen von Hangman");
    }

    /**
     * Ausgabe beim Beenden
     *
     * @param joinPoint
     */
    @After("definePointcut()")
    public void zumSchluss(JoinPoint joinPoint) {
        System.out.println("Bis zum nächsten Mal wenn es wieder heisst: Hangman Tod oder Leben!");
    }
}
