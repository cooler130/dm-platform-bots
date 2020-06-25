package com.cooler.ai.dm.taskaction.interact;

import com.cooler.ai.dm.constant.BC;
import com.cooler.ai.nlg.entity.NlgGuidesInfo;
import com.cooler.ai.platform.action.BaseInteractiveTaskAction;
import com.cooler.ai.platform.facade.constance.Constant;
import com.cooler.ai.platform.facade.constance.PC;
import com.cooler.ai.platform.facade.model.Message;
import com.cooler.ai.platform.model.EntityConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author zhangsheng
 * @Description
 * @Date 2018/12/25
 **/
@Component("showQRCodeTaskAction")
public class ShowQRCodeTaskAction extends BaseInnerInteractTaskAction {
    private Logger logger = LoggerFactory.getLogger(ShowQRCodeTaskAction.class);

    @Override
    protected Message createReplyMessage() {
        String transformIntentName = getPCParamValueOrDefault(PC.TRANSFORM_INTENT_NAME, EntityConstant.NO_INTENT);
        String intentName = getPCParamValueOrDefault(PC.INTENT_NAME, EntityConstant.NO_INTENT);

        NlgGuidesInfo nlgGuidesInfo = getNlgGuidesInfoOfDefaultTheme(this.getClass(), transformIntentName, intentName, null);
        String nlgSentence = addNlgGuidesInfoToBizMap(nlgGuidesInfo, Constant.ONE);
        return new Message(Constant.MSG_TEXT, nlgSentence);
    }

    @Override
    protected Message createOtherMessage() {
        String qrCode = getBizDataValue(BC.QR_CODE);                                                                    //这是个二进制流转成的字符串，或许可以直接传一个二维码图片地址
        return new Message(Constant.MSG_IMAGE, qrCode);
    }
}
