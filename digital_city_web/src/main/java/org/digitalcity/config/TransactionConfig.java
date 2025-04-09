package org.digitalcity.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: 数据库事务配置
 *
 * @author xupengxin
 * @date 2024/1/27
 */
@Configuration
@Aspect
public class TransactionConfig {
    private static final int TRANSACTION_METHOD_TIMEOUT = 5;
    // 定义切面表达式
    private static final String AOP_POINT_EXPRESSION = "execution (* org.digitalcity..service..*.*(..))";

    @Autowired
    private TransactionManager transactionManager;

    @Bean("txAdvice")
    public TransactionInterceptor transactionInterceptor() {
        RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
        readOnly.setReadOnly(true);
        readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);

        RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
        required.setTimeout(TRANSACTION_METHOD_TIMEOUT);
        required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        Map<String, TransactionAttribute> transactionAttributeMap = new HashMap<>();
        transactionAttributeMap.put("add*", required);
        transactionAttributeMap.put("register*", required);
        transactionAttributeMap.put("delete*", required);
        transactionAttributeMap.put("update*", required);
        transactionAttributeMap.put("find*", readOnly);
        transactionAttributeMap.put("list*", readOnly);
        transactionAttributeMap.put("get*", readOnly);
        transactionAttributeMap.put("login*", readOnly);
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.setNameMap(transactionAttributeMap);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor advisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, transactionInterceptor());
    }
}
