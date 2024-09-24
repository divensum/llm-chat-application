import {AppLayout} from "@hilla/react-components/AppLayout";
import {NavLink, Outlet} from "react-router-dom";
import {Suspense} from "react";
import {DrawerToggle} from "@hilla/react-components/DrawerToggle";
import {useRouteMetadata} from 'Frontend/util/routing';

const navLinkClasses = ({ isActive }: any) => {
    return `block rounded-m p-s ${isActive ? 'bg-primary-10 text-primary' : 'text-body'}`;
};

export default function MainView() {
    const currentTitle = useRouteMetadata()?.title ?? 'AI app';
    return (
        <AppLayout primarySection="drawer">
            <div slot="drawer" className="flex flex-col justify-between h-full p-m">
                <header className="flex flex-col gap-m">
                   <h1 className="text-l m-0">🤖 AI Chat Boot</h1>
                    <nav>
                        <NavLink className={navLinkClasses} to="/">
                            Chat
                        </NavLink>
                        <NavLink className={navLinkClasses} to="/stream-chat">
                            Streaming Chat
                        </NavLink>
                        <NavLink className={navLinkClasses} to="/stream-assistant">
                            Streaming Assistant
                        </NavLink>
                        <NavLink className={navLinkClasses} to="/greedy-driver">
                            Greedy Taxi Driver
                        </NavLink>
                    </nav>
                </header>
            </div>

            <DrawerToggle slot="navbar" aria-label="Menu toggle"></DrawerToggle>
            <h2 slot="navbar" className="text-l m-0">
               {currentTitle}
            </h2>
            <Suspense>
                <Outlet />
            </Suspense>
        </AppLayout>
    );
}
