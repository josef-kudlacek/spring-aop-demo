package eu.kudljo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* eu.kudljo.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* eu.kudljo.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* eu.kudljo.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
