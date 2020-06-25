package com.cooler.ai.dm.taskaction.interact;

import com.cooler.ai.dm.constant.BC;
import com.cooler.ai.nlg.entity.GuideOptionInfo;
import com.cooler.ai.nlg.entity.NlgGuidesInfo;
import com.cooler.ai.nlg.entity.NlgTemplateInfo;
import com.cooler.ai.platform.action.BaseInteractiveTaskAction;
import com.cooler.ai.platform.facade.constance.Constant;
import com.cooler.ai.platform.facade.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2018/12/25
 **/
@Component("showFaqAnswerTaskAction")
public class ShowFaqAnswerTaskAction extends BaseInnerInteractTaskAction {
    private Logger logger = LoggerFactory.getLogger(ShowFaqAnswerTaskAction.class);

    @Override
    protected Message createReplyMessage() {
        addNlgGuidesInfoToBizMap(new NlgGuidesInfo(new NlgTemplateInfo(), new ArrayList<GuideOptionInfo>()), Constant.ONE);

        String faqAnswer = getBizDataValue(BC.FAQ_ANSWER);
        return new Message(Constant.MSG_TEXT, faqAnswer);
    }

}
