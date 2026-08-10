FROM rabbitmq:3.8.5-management

# 安装 delayed message exchange 插件
COPY rabbitmq_delayed_message_exchange-3.9.0.ez /plugins/

# 离线启用插件
RUN rabbitmq-plugins enable --offline rabbitmq_delayed_message_exchange