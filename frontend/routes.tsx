import MainView from "Frontend/views/MainView.js";
import {
    createBrowserRouter,
    RouteObject
} from "react-router-dom";
import ChatView from "Frontend/views/chat/ChatView"
import StreamChatView from "Frontend/views/streamchat/StreamChatView"
import StreamAssistantView from "Frontend/views/streamassistant/StreamAssistantView"
import GreedyDriverView from "Frontend/views/greedydriverchat/GreedyDriverView"

export const routes: readonly RouteObject[] = [
  {
      element: <MainView />,
      handle: { title: 'Main' },
      children: [
          { path: '/', element: <ChatView />, handle: { title: 'Chat' } },
          { path: '/stream-chat', element: <StreamChatView />, handle: { title: 'Streaming Chat' } },
          { path: '/stream-assistant', element: <StreamAssistantView />, handle: { title: 'Assistant Chat (with memory)' } },
          { path: '/greedy-driver', element: <GreedyDriverView />, handle: { title: 'Greedy Driver Chat (try to get a free ride 😉)' } },
      ],
    },
];

export const router = createBrowserRouter([...routes], {basename: new URL(document.baseURI).pathname });
