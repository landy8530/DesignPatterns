package org.landy.business.rules.aop;

import org.apache.commons.lang.ObjectUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.landy.business.rules.annotation.StatusCheck;
import org.landy.business.rules.domain.CheckResult;
import org.landy.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

/**
 * @author landyl
 * @create 2:42 PM 09/23/2018
 */
@Component
@Aspect
public class StatusCheckAspect {
    private static final int VALID_UPDATE = Constants.UPDATE_STATUS_VALID_UPDATE;

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusCheckAspect.class);


    //定义切入点:定义一个方法，用于声明切面表达式，一般地，该方法中不再需要添加其他的代码
    @Pointcut("execution(* org.landy.business.rules..*(..)) && @annotation(org.landy.business.rules.annotation.StatusCheck)")
    public void declareJoinPointExpression() {}

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before("declareJoinPointExpression()")
    public void beforeCheck(JoinPoint joinPoint) {
        System.out.println("before statusCheck method start ...");
        System.out.println("target class:" + joinPoint.getTarget());
        //获得自定义注解的参数
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + methodName + " begins with " + args);
        System.out.println("before statusCheck method end ...");
    }

    /**
     * 环绕通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("declareJoinPointExpression()")
    public Object doCheck(ProceedingJoinPoint pjp) throws Throwable {
        LOGGER.info("Status check around method start ....");
        Signature signature = pjp.getSignature();
        Class clazz = signature.getDeclaringType();
        boolean check = false;
        Method[] ms = clazz.getMethods();
        Method method = null;
        for(Method m : ms){
            boolean isMExist = m.isAnnotationPresent(StatusCheck.class);
            if(isMExist){
                check = true;
                method = m;
            }
        }

        if(check) {
            Object[] paramValues = pjp.getArgs();
            LOGGER.info("Status check dynamic AOP,paramValues:{}",paramValues);
            CheckResult checkResult = check(method,paramValues);
            if (checkResult != null && checkResult.getCheckResult() != VALID_UPDATE) {
                LOGGER.error("Status check failure,check method:{},paramValues:{},checkMsg:{}",method.getName(),paramValues,checkResult.getCheckMessage());
                return checkResult;
            }

        }
        //execute the target method
        CheckResult result = (CheckResult)pjp.proceed();
        LOGGER.info("execute the target method,the return result_msg:{}",result.getCheckMessage());
        LOGGER.info("Status check around method end ....");
        return result;
    }

    /** 最终通知 after advice
     * 使用的是在上面声明的切面，并且带上个注解，意思是除了满足上面statusCheck()方法的条件还得带上注解才OK
     *
     **/
    @After(value = "declareJoinPointExpression()", argNames = "joinPoint")
    public void methodAfter(JoinPoint joinPoint) {
        System.out.println("After method     start.......................");

        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends");

        System.out.println("After method     end.......................");
    }

    /**
     * 后置通知
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "declareJoinPointExpression()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("AfterReturning method     start.......................");
        System.out.println(" 此处可以对返回值做进一步处理");
        System.out.println(" 可通过joinPoint来获取所需要的内容");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + " ends with " + result);
        System.out.println("AfterReturning method     end.......................");
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "declareJoinPointExpression()", throwing = "ex")
    public void afterThrowin(JoinPoint joinPoint, Exception ex) {
        System.out.println(" 此处意在执行核心业务逻辑出错时，捕获异常，并可做一些日志记录操作等等");
        System.out.println(" 可通过joinPoint来获取所需要的内容");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The method " + methodName + "occurs exception "+ ex);
    }


    private CheckResult check(Method method, Object[] paramValues)  {

        boolean isMExist = method.isAnnotationPresent(StatusCheck.class);
        if(isMExist){
            Parameter[] parameters = method.getParameters();

            if(parameters.length >= 2) {
                if(paramValues != null) {
                    String updateStatusCode = ObjectUtils.toString(paramValues[0]);
                    String fromStatusCode = ObjectUtils.toString(paramValues[1]);
                    System.out.println("AOP实际校验逻辑。。。。" + updateStatusCode + "----" + fromStatusCode);
                    if("1".equals(updateStatusCode)) {
                        CheckResult checkResult = new CheckResult();
                        checkResult.setCheckResult(1);
                        checkResult.setCheckMessage("校验失败");
                        return checkResult;
                    }
                }
            }
        }

        return new CheckResult();
    }



}
