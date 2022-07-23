package com.websocket.chat.controller;

import com.websocket.chat.config.HttpCode;
import com.websocket.chat.model.ChatRoom;
import com.websocket.chat.repo.ChatRoomRepository;
import com.websocket.chat.service.ChatRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomService chatRoomService;

    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/room";
    }

    @Operation(summary = "방 생성 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_OK, description = "방 생성",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ChatRoom.class))}),
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_FORBIDDEN, description = "로그인 필요", content = @Content),
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_BADREQUEST, description = "요청 데이터 오류", content = @Content),
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_SERVERERROR, description = "서버 오류", content = @Content)
    })
    @PostMapping("/room")
    @ResponseBody
    public ChatRoom createRoom(String name) {
//        return chatRoomService.createChatRoom(name);
        return chatRoomService.createChatRoom(name);
    }

    @GetMapping("/room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "/chat/roomdetail";
    }

    @Operation(summary = "특정 방 찾기 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_OK, description = "방 생성",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ChatRoom.class))}),
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_FORBIDDEN, description = "로그인 필요", content = @Content),
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_BADREQUEST, description = "요청 데이터 오류", content = @Content),
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_SERVERERROR, description = "서버 오류", content = @Content)
    })
    @GetMapping("/room/{roomId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomId) {
        return chatRoomRepository.findRoomById(roomId);
    }

    @Operation(summary = "모든 방 찾기 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_OK, description = "방 생성",
                    content = {@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ChatRoom.class)))}),
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_FORBIDDEN, description = "로그인 필요", content = @Content),
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_BADREQUEST, description = "요청 데이터 오류", content = @Content),
            @ApiResponse(responseCode = HttpCode.HTTPSTATUS_SERVERERROR, description = "서버 오류", content = @Content)
    })
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatRoomRepository.findAllRoom();
    }
}
