package ooo.foooooooooooo.velocitydiscord.config;

import com.electronwill.nightconfig.core.Config;

import java.awt.*;
import java.util.Optional;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public class DiscordMessageConfig extends BaseConfig {
  public DiscordMessageConfig(Config config) {
    loadConfig(config);
  }

  // chat
  public Optional<String> MESSAGE_FORMAT = Optional.of("{username}: {message}");
  public UserMessageType MESSAGE_TYPE = UserMessageType.TEXT;
  public Optional<Color> MESSAGE_EMBED_COLOR = Optional.empty();

  public Optional<String> DEATH_MESSAGE_FORMAT = Optional.of("**{username} {death_message}**");
  public UserMessageType DEATH_MESSAGE_TYPE = UserMessageType.TEXT;
  public Optional<Color> DEATH_MESSAGE_EMBED_COLOR = Optional.of(new Color(0xbf4040));

  public Optional<String> ADVANCEMENT_MESSAGE_FORMAT = Optional.of("**{username} has made the advancement __{advancement_title}__**\n_{advancement_description}_");
  public UserMessageType ADVANCEMENT_MESSAGE_TYPE = UserMessageType.TEXT;
  public Optional<Color> ADVANCEMENT_MESSAGE_EMBED_COLOR = Optional.of(new Color(0x40bf4f));

  // join/leave
  public Optional<String> JOIN_MESSAGE_FORMAT = Optional.of("**{username} joined the game**");
  public UserMessageType JOIN_MESSAGE_TYPE = UserMessageType.TEXT;
  public Optional<Color> JOIN_MESSAGE_EMBED_COLOR = Optional.of(new Color(0x40bf4f));

  public Optional<String> LEAVE_MESSAGE_FORMAT = Optional.of("**{username} left the game**");
  public UserMessageType LEAVE_MESSAGE_TYPE = UserMessageType.TEXT;
  public Optional<Color> LEAVE_MESSAGE_EMBED_COLOR = Optional.of(new Color(0xbf4040));

  public Optional<String> DISCONNECT_MESSAGE_FORMAT = Optional.of("**{username} disconnected**");
  public UserMessageType DISCONNECT_MESSAGE_TYPE = UserMessageType.TEXT;
  public Optional<Color> DISCONNECT_MESSAGE_EMBED_COLOR = Optional.of(new Color(0xbf4040));

  public Optional<String> SERVER_SWITCH_MESSAGE_FORMAT = Optional.of("**{username} moved to {current} from {previous}**");
  public UserMessageType SERVER_SWITCH_MESSAGE_TYPE = UserMessageType.TEXT;
  public Optional<Color> SERVER_SWITCH_MESSAGE_EMBED_COLOR = Optional.of(new Color(0x40bf4f));

  // proxy start/stop, server start/stop
  public Optional<String> PROXY_START_MESSAGE_FORMAT = Optional.of("**Proxy started**");
  public MessageType PROXY_START_MESSAGE_TYPE = MessageType.TEXT;
  public Optional<Color> PROXY_START_MESSAGE_EMBED_COLOR = Optional.of(new Color(0x40bf4f));

  public Optional<String> PROXY_STOP_MESSAGE_FORMAT = Optional.of("**Proxy stopped**");
  public MessageType PROXY_STOP_MESSAGE_TYPE = MessageType.TEXT;
  public Optional<Color> PROXY_STOP_MESSAGE_EMBED_COLOR = Optional.of(new Color(0xbf4040));

  public Optional<String> SERVER_START_MESSAGE_FORMAT = Optional.of("**{server} has started**");
  public MessageType SERVER_START_MESSAGE_TYPE = MessageType.TEXT;
  public Optional<Color> SERVER_START_MESSAGE_EMBED_COLOR = Optional.of(new Color(0x40bf4f));

  public Optional<String> SERVER_STOP_MESSAGE_FORMAT = Optional.of("**{server} has stopped**");
  public MessageType SERVER_STOP_MESSAGE_TYPE = MessageType.TEXT;
  public Optional<Color> SERVER_STOP_MESSAGE_EMBED_COLOR = Optional.of(new Color(0xbf4040));

  // channel topic
  public Optional<String> TOPIC_FORMAT = Optional.of(
    """
      {players}/{max_players}
      {player_list}
      {hostname}:{port}
      Uptime: {uptime}"""
  );

  public Optional<String> TOPIC_SERVER_FORMAT = Optional.of("{name}: {players}/{max_players}");
  public Optional<String> TOPIC_SERVER_OFFLINE_FORMAT = Optional.of("{name}: Offline");

  public Optional<String> TOPIC_PLAYER_LIST_NO_PLAYERS_HEADER = Optional.of("No players online");
  public Optional<String> TOPIC_PLAYER_LIST_HEADER = Optional.of("Players: ");
  public String TOPIC_PLAYER_LIST_FORMAT = "{username}";
  public String TOPIC_PLAYER_LIST_SEPARATOR = ", ";
  public int TOPIC_PLAYER_LIST_MAX_COUNT = 10;

  @Override
  protected void loadConfig(Config config) {
    MESSAGE_FORMAT = getOptional(config, "discord.chat.message", MESSAGE_FORMAT);

    // old config value not actually present in example config
    var useWebhooks = get(config, "discord.use_webhook", false);

    // if useWebhooks is true, force MESSAGE_TYPE to be WEBHOOK to not
    // break old behavior if someone didn't update their config
    if (useWebhooks) {
      MESSAGE_TYPE = UserMessageType.WEBHOOK;
    } else {
      MESSAGE_TYPE = getUserMessageType(config, "discord.chat.message_type", MESSAGE_TYPE);
    }
    MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.message_embed_color", MESSAGE_EMBED_COLOR);

    DEATH_MESSAGE_FORMAT = getOptional(config, "discord.chat.death_message", DEATH_MESSAGE_FORMAT);
    DEATH_MESSAGE_TYPE = getUserMessageType(config, "discord.chat.death_message_type", DEATH_MESSAGE_TYPE);
    DEATH_MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.death_message_embed_color", DEATH_MESSAGE_EMBED_COLOR);

    ADVANCEMENT_MESSAGE_FORMAT = getOptional(config, "discord.chat.advancement_message", ADVANCEMENT_MESSAGE_FORMAT);
    ADVANCEMENT_MESSAGE_TYPE = getUserMessageType(config, "discord.chat.advancement_message_type", ADVANCEMENT_MESSAGE_TYPE);
    ADVANCEMENT_MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.advancement_message_embed_color", ADVANCEMENT_MESSAGE_EMBED_COLOR);

    JOIN_MESSAGE_FORMAT = getOptional(config, "discord.chat.join_message", JOIN_MESSAGE_FORMAT);
    JOIN_MESSAGE_TYPE = getUserMessageType(config, "discord.chat.join_message_type", JOIN_MESSAGE_TYPE);
    JOIN_MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.join_message_embed_color", JOIN_MESSAGE_EMBED_COLOR);

    LEAVE_MESSAGE_FORMAT = getOptional(config, "discord.chat.leave_message", LEAVE_MESSAGE_FORMAT);
    LEAVE_MESSAGE_TYPE = getUserMessageType(config, "discord.chat.leave_message_type", LEAVE_MESSAGE_TYPE);
    LEAVE_MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.leave_message_embed_color", LEAVE_MESSAGE_EMBED_COLOR);

    DISCONNECT_MESSAGE_FORMAT = getOptional(config, "discord.chat.disconnect_message", DISCONNECT_MESSAGE_FORMAT);
    DISCONNECT_MESSAGE_TYPE = getUserMessageType(config, "discord.chat.disconnect_message_type", DISCONNECT_MESSAGE_TYPE);
    DISCONNECT_MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.disconnect_message_embed_color", DISCONNECT_MESSAGE_EMBED_COLOR);

    SERVER_SWITCH_MESSAGE_FORMAT = getOptional(config, "discord.chat.server_switch_message", SERVER_SWITCH_MESSAGE_FORMAT);
    SERVER_SWITCH_MESSAGE_TYPE = getUserMessageType(config, "discord.chat.server_switch_message_type", SERVER_SWITCH_MESSAGE_TYPE);
    SERVER_SWITCH_MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.server_switch_message_embed_color", SERVER_SWITCH_MESSAGE_EMBED_COLOR);

    PROXY_START_MESSAGE_FORMAT = getOptional(config, "discord.chat.proxy_start_message", PROXY_START_MESSAGE_FORMAT);
    PROXY_START_MESSAGE_TYPE = getMessageType(config, "discord.chat.proxy_start_message_type", PROXY_START_MESSAGE_TYPE);
    PROXY_START_MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.proxy_start_message_embed_color", PROXY_START_MESSAGE_EMBED_COLOR);

    PROXY_STOP_MESSAGE_FORMAT = getOptional(config, "discord.chat.proxy_stop_message", PROXY_STOP_MESSAGE_FORMAT);
    PROXY_STOP_MESSAGE_TYPE = getMessageType(config, "discord.chat.proxy_stop_message_type", PROXY_STOP_MESSAGE_TYPE);
    PROXY_STOP_MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.proxy_stop_message_embed_color", PROXY_STOP_MESSAGE_EMBED_COLOR);

    SERVER_START_MESSAGE_FORMAT = getOptional(config, "discord.chat.server_start_message", SERVER_START_MESSAGE_FORMAT);
    SERVER_START_MESSAGE_TYPE = getMessageType(config, "discord.chat.server_start_message_type", SERVER_START_MESSAGE_TYPE);
    SERVER_START_MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.server_start_message_embed_color", SERVER_START_MESSAGE_EMBED_COLOR);

    SERVER_STOP_MESSAGE_FORMAT = getOptional(config, "discord.chat.server_stop_message", SERVER_STOP_MESSAGE_FORMAT);
    SERVER_STOP_MESSAGE_TYPE = getMessageType(config, "discord.chat.server_stop_message_type", SERVER_STOP_MESSAGE_TYPE);
    SERVER_STOP_MESSAGE_EMBED_COLOR = getColor(config, "discord.chat.server_stop_message_embed_color", SERVER_STOP_MESSAGE_EMBED_COLOR);

    TOPIC_FORMAT = getOptional(config, "discord.topic", TOPIC_FORMAT);

    TOPIC_SERVER_FORMAT = getOptional(config, "discord.topic_server", TOPIC_SERVER_FORMAT);
    TOPIC_SERVER_OFFLINE_FORMAT = getOptional(config, "discord.topic_server_offline", TOPIC_SERVER_OFFLINE_FORMAT);

    TOPIC_PLAYER_LIST_NO_PLAYERS_HEADER = getOptional(config, "discord.topic_player_list_no_players_header", TOPIC_PLAYER_LIST_NO_PLAYERS_HEADER);
    TOPIC_PLAYER_LIST_HEADER = getOptional(config, "discord.topic_player_list_header", TOPIC_PLAYER_LIST_HEADER);
    TOPIC_PLAYER_LIST_FORMAT = get(config, "discord.topic_player_list_player", TOPIC_PLAYER_LIST_FORMAT);
    TOPIC_PLAYER_LIST_SEPARATOR = get(config, "discord.topic_player_list_separator", TOPIC_PLAYER_LIST_SEPARATOR);
    TOPIC_PLAYER_LIST_MAX_COUNT = get(config, "discord.topic_player_list_max_count", TOPIC_PLAYER_LIST_MAX_COUNT);
  }

  private Optional<Color> getColor(Config config, String key, Optional<Color> defaultValue) {
    var defaultHex = defaultValue.map((c) -> String.format("#%06X", (0xFFFFFF & c.getRGB())));
    return getOptional(config, key, defaultHex).map(Color::decode);
  }

  private MessageType getMessageType(Config config, String key, MessageType defaultValue) {
    var type = get(config, key, defaultValue.toString().toLowerCase());
    return switch (type) {
      case "text" -> MessageType.TEXT;
      case "embed" -> MessageType.EMBED;
      case "" -> defaultValue;
      default -> throw new RuntimeException("Invalid message type: " + type);
    };
  }

  private UserMessageType getUserMessageType(Config config, String key, UserMessageType defaultValue) {
    var type = get(config, key, defaultValue.toString().toLowerCase());
    return switch (type) {
      case "text" -> UserMessageType.TEXT;
      case "webhook" -> UserMessageType.WEBHOOK;
      case "embed" -> UserMessageType.EMBED;
      case "" -> defaultValue;
      default -> throw new RuntimeException("Invalid message type: " + type);
    };
  }

  public boolean isWebhookEnabled() {
    return MESSAGE_TYPE == UserMessageType.WEBHOOK;
  }

  public enum UserMessageType {
    TEXT,
    WEBHOOK,
    EMBED
  }

  public enum MessageType {
    TEXT,
    EMBED
  }
}
