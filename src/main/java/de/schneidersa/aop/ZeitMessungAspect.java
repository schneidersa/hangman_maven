package de.schneidersa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Aspekt der die benötigte Zeit zur Eingabe ausgibt
 *
 * @author Sandra Schneider
 */
@Aspect
public class ZeitMessungAspect {

    /**
     * behandle handleUserInput
     */
    @Pointcut("call(* de.schneidersa.GameLogic.handleUserInput() )")
    public void definePointcut() {
    }

    /**
     * Zeit Messung mit @Around
     *
     * @param thisJoinPoint Join Point
     * @throws Throwable
     */
    @Around("definePointcut()")
    public void vorDemStart(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        final long start = System.nanoTime();
        thisJoinPoint.proceed();
        final long end = System.nanoTime();
        System.out.println("Benötigte Zeit für Eingabe: " + ((end - start) / 1000000 + " ms"));
    }

}
