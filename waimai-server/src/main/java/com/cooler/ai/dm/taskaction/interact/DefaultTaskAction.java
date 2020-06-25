package com.cooler.ai.dm.taskaction.interact;

import com.cooler.ai.nlg.NlgConstant;
import com.cooler.ai.nlg.entity.NlgGuidesInfo;
import com.cooler.ai.nlg.entity.NlgTemplateInfo;
import com.cooler.ai.platform.action.BaseInteractiveTaskAction;
import com.cooler.ai.platform.facade.constance.Constant;
import com.cooler.ai.platform.facade.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @Author zhangsheng
 * @Description
 * @Date 2018/12/25
 **/
@Component("defaultTaskAction")
public class DefaultTaskAction extends BaseInnerInteractTaskAction {
    private Logger logger = LoggerFactory.getLogger(DefaultTaskAction.class);

    @Override
    protected Message createReplyMessage() {
        NlgGuidesInfo nlgGuidesInfo = getNlgGuidesInfoOfDefaultTheme(this.getClass(), NlgConstant.V_NONE_VALUE, NlgConstant.V_NONE_VALUE, null);
        String nlgSentence = addNlgGuidesInfoToBizMap(nlgGuidesInfo, Constant.ONE);
        return new Message(Constant.MSG_TEXT, nlgSentence);
    }
}
